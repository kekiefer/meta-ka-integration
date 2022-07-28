SUMMARY = "Dependencies for K-A system"
SECTION = "development"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PV = "1.0"
PR = "r1"

inherit packagegroup

PACKAGES += "\
    ${PN}-runtime \
    ${PN}-development \
"

RRECOMMENDS:${PN} = "\
    ${PN}-runtime \
    ${PN}-development \
"

# Packages for K-A integration runtime
RDEPENDS:${PN}-runtime = "\
    python3-aiohttp \
    python3-async-timeout \
    python3-attrs \
    python3-boto3 \
    python3-cloudpickle \
    python3-dataclass-wizard \
    python3-filterpy \
    python3-genson \
    python3-greenlet \
    python3-hydra \
    python3-idna \
    python3-injector \
    python3-iopath \
    python3-jsonschema \
    python3-msgpack \
    python3-nanoid \
    python3-numpy \
    python3-omegaconf \
    python3-opencv \
    python3-pandas \
    python3-pillow \
    python3-dotenv \
    python3-engineio \
    python3-socketio \
    python3-pyturbojpeg \
    python3-pyyaml \
    python3-pyzmq \
    python3-requests \
    python3-rich \
    python3-scipy \
    python3-tabulate \
    python3-tqdm \
    python3-typing-extensions \
    python3-webcolors \
    python3-yarl \
    python3-torch \
    python3-torchvision \
"

# various things used for development/debugging, not production
RDEPENDS:${PN}-development = "\
    ${PN}-runtime \
    python3-tensorrt \
"
