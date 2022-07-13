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
"

# various things used for development/debugging, not production
RDEPENDS:${PN}-development = "\
    ${PN}-runtime \
    python3-tensorrt \
"
