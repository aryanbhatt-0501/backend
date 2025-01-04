from fastapi import FastAPI
from pydantic import BaseModel
from typing import List
from collections import defaultdict, deque
from fastapi.middleware.cors import CORSMiddleware

app = FastAPI()

# Define the structure for nodes and edges
class Node(BaseModel):
    id: str

class Edge(BaseModel):
    source: str
    target: str

class Pipeline(BaseModel):
    nodes: List[Node]
    edges: List[Edge]

# Helper function to check if the graph is a DAG
def is_dag(edges):
    # Create an adjacency list and in-degree count
    graph = defaultdict(list)
    in_degree = defaultdict(int)

    for edge in edges:
        graph[edge.source].append(edge.target)
        in_degree[edge.target] += 1
        if edge.source not in in_degree:
            in_degree[edge.source] = 0

    # Perform topological sorting (Kahn's algorithm)
    queue = deque([node for node in in_degree if in_degree[node] == 0])
    visited_count = 0

    while queue:
        current = queue.popleft()
        visited_count += 1
        for neighbor in graph[current]:
            in_degree[neighbor] -= 1
            if in_degree[neighbor] == 0:
                queue.append(neighbor)

    # If all nodes are visited, it's a DAG
    return visited_count == len(in_degree)

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],  # Adjust this to restrict allowed origins
    allow_credentials=True,
    allow_methods=["*"],  # Allows all HTTP methods
    allow_headers=["*"],  # Allows all headers
)

@app.get("/")
def read_root():
    return {"Ping": "Pong"}

@app.post("/pipelines/parse")
def parse_pipeline(pipeline: Pipeline):
    nodes = pipeline.nodes
    edges = pipeline.edges

    num_nodes = len(nodes)
    num_edges = len(edges)

    dag_status = is_dag(edges)

    return {
        "num_nodes": num_nodes,
        "num_edges": num_edges,
        "is_dag": dag_status,
    }
