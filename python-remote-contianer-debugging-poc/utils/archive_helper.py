import os
import libarchive.public

def extract_archive(archive_path: str, extract_to: str):
    os.makedirs(extract_to, exist_ok=True)

    with libarchive.public.file_reader(archive_path) as e:
        for entry in e:
            entry_path = os.path.join(extract_to, entry.pathname)

            # Skip macOS metadata entries
            if entry.pathname.startswith('__MACOSX') or os.path.basename(entry.pathname).startswith('._'):
                continue

            if entry.pathname.endswith('/'):
                # It's a directory
                os.makedirs(entry_path, exist_ok=True)
            else:
                # Ensure parent directories exist
                os.makedirs(os.path.dirname(entry_path), exist_ok=True)

                with open(entry_path, 'wb') as f:
                    for block in entry.get_blocks():
                        f.write(block)
    print(f"Extracted {archive_path} to {extract_to}")
