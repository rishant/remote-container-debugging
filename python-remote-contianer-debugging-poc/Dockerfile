FROM ubuntu:22.04

ENV DEBIAN_FRONTEND=noninteractive

# Install Python 3.8 and bash
RUN apt-get update && \
    apt-get install -y \
        software-properties-common \
        curl \
        wget \
        bash \
        ca-certificates && \
    add-apt-repository ppa:deadsnakes/ppa && \
    apt-get update && \
    apt-get install -y python3.9 python3.9-distutils libarchive-dev && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Step 2: Install pip for Python 3.8
RUN curl -sS https://bootstrap.pypa.io/get-pip.py -o get-pip.py && \
    python3.9 get-pip.py && \
    rm get-pip.py

# Install debugpy (VSCode Python debugger)
# RUN python3.9 -m pip install --no-cache-dir debugpy
# RUN python3.9 -m pip install --no-cache-dir libarchive

# Install Python packages
COPY requirements.txt /tmp/requirements.txt
RUN python3.9 -m pip install --no-cache-dir -r /tmp/requirements.txt


# Set work directory
WORKDIR /app

# Copy entire CLI project into the container
COPY . .

# Optional: expose VS Code debug port
EXPOSE 5678

# With:
CMD ["bash"]