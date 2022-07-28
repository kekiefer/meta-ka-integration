SUMMARY = "Ahead of Time compiler for numeric kernels"
HOMEPAGE = "https://github.com/serge-sans-paille/pythran"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e277a0b6033e0cb3d510c86b74144b01"

SRC_URI += "file://0001-Disable-default-library-stripping.patch"
SRC_URI[md5sum] = "e09e90484771937ab499380858bdb18d"
SRC_URI[sha256sum] = "0b2cba712e09f7630879dff69f268460bfe34a6d6000451b47d598558a92a875"

S = "${WORKDIR}/pythran-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-beniget python3-gast python3-numpy python3-ply"

BBCLASSEXTEND = "native nativesdk"
