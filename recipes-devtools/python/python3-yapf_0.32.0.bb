SUMMARY = "A formatter for Python code."
HOMEPAGE = "https://github.com/google/yapf"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[sha256sum] = "a3f5085d37ef7e3e004c4ba9f9b3e40c54ff1901cd111f05145ae313a7c67d1b"

S = "${WORKDIR}/yapf-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-core"
