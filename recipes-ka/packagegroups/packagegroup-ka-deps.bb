SUMMARY = "Dependencies for K-A system"
SECTION = "development"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PV = "1.0"
PR = "r1"

inherit packagegroup

PACKAGES += "\
    ${PN}-drt \
    ${PN}-art \
    ${PN}-development \
"

RRECOMMENDS:${PN} = "\
    ${PN}-drt \
    ${PN}-art \
"

# Packages for K-A integration runtime
RDEPENDS:${PN}-drt = "\
    onnxruntime \
    python3-aiohttp \
    python3-async-timeout \
    python3-attrs \
    python3-boto3 \
    python3-cloudpathlib \
    python3-cloudpickle \
    python3-dataclass-wizard \
    python3-filterpy \
    python3-genson \
    python3-greenlet \
    python3-haggis \
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
    python3-engineio \
    python3-socketio \
    python3-pyturbojpeg \
    python3-pyyaml \
    python3-pyzmq \
    python3-requests \
    python3-rich \
    python3-rule-engine \
    python3-scikit-image \
    python3-scipy \
    python3-seaborn \
    python3-shapely \
    python3-tqdm \
    python3-typing-extensions \
    python3-webcolors \
    python3-yarl \
"

RDEPENDS:${PN}-art = "\
    nodejs \
"

# various things used for development/debugging, not production
RDEPENDS:${PN}-development = "\
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-good \
    gstreamer1.0-plugins-tegra \
    nsight-systems-cli \
    python3-dotenv \
    python3-nvtx \
    python3-pygobject \
"
