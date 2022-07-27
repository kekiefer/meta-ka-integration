SUMMARY = "A library for providing I/O abstraction."
HOMEPAGE = "https://github.com/facebookresearch/iopath"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=901f6cd9846257b3a9c69dbd0a49caf1"

SRC_URI[sha256sum] = "3311c16a4d9137223e20f141655759933e1eda24f8bff166af834af3c645ef01"

S = "${WORKDIR}/iopath-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-core"
