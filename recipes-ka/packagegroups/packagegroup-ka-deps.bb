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
    python3-scipy \
    python3-torch \
    python3-torchvision \
"

# various things used for development/debugging, not production
RDEPENDS:${PN}-development = "\
    ${PN}-runtime \
    python3-tensorrt \
"
