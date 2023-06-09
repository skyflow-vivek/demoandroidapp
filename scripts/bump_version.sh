Version=$1
SEMVER=$Version

if [ -z $2 ]; then
    echo "Bumping package version to $1"

    sed -E "s/mVersionName = .+/mVersionName = \"$SEMVER\"/g" app/build.gradle >tempfile && cat tempfile >app/build.gradle && rm -f tempfile

    echo --------------------------
    echo "Done, Package now at $1"
else
    echo "Bumping package version to $1-beta.$2"

    sed -E "s/mVersionName = .+/mVersionName = \"$SEMVER-beta.$2\"/g" app/build.gradle >tempfile && cat tempfile >app/build.gradle && rm -f tempfile

    echo --------------------------
    echo "Done, Package now at $1-beta.$2"
fi
