# Prerequisites
1. Docker-Dasktop | Rancher-Dasktop | Podman
2. VSCode
3. VSCode Plugins:- Docker, python, Remote Development


# Build docker image:
cmd:/>cd c:/project_poc
cmd: c/project_poc> docker build -f Dockerfile -t rishantgupta007/python-cli-poc:1.0 .


# Run normally docker image:
cmd: c/project_poc> docker run --rm -it rishantgupta007/python-cli-poc:1.0 bash
cmd: c/project_poc> docker run --rm -it rishantgupta007/python-cli-poc:1.0 python3.9 hello.py

# Run docker image with VS Code debug attached:
cmd: c/project_poc> docker run --rm -it -p 5678:5678 rishantgupta007/python-cli-poc:1.0 python3.9 -m debugpy --listen 0.0.0.0:5678 --wait-for-client hello.py


# VS Code Configuration (Launch Config)

In your host VS Code, add this to `.vscode/launch.json`:

{
  "version": "0.2.0",
  "configurations": [
    {
      "name": "Python: Remote Attach",
      "type": "debugpy",
      "request": "attach",
      "connect": {
        "host": "localhost",
        "port": 5678
      },
      "pathMappings": [
        {
          "localRoot": "${workspaceFolder}",
          "remoteRoot": "/app"
        }
      ]
    }
  ]
}

Notes: Replace ${workspaceFolder} with the absolute path if needed.
