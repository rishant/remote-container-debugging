import argparse
from utils.archive_helper import extract_archive


def main():
    parser = argparse.ArgumentParser(description="Extract archives using libarchive")
    parser.add_argument('--archive_file', required=True, help="Path to the archive file (e.g., /files/input.zip)")
    parser.add_argument('--archive_output', required=True, help="Output directory to extract to (e.g., /files/extracted/)")

    args = parser.parse_args()
    
    # extract_archive("/files/input.zip", "/files/extracted/")
    extract_archive(args.archive_file, args.archive_output)

if __name__ == "__main__":
    print('Hello python cli project!')
    main()
