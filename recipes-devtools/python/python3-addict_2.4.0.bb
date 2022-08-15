SUMMARY = "Addict is a dictionary whose items can be set using both attribute and item syntax."
HOMEPAGE = "https://github.com/mewwts/addict"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=068bc3fbaaf54a0fd7d3c7f47b7df5fa"

SRC_URI[sha256sum] = "b3b2210e0e067a281f5646c8c5db92e99b7231ea8b0eb5f74dbdf9e259d4e494"

S = "${WORKDIR}/addict-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-core"
