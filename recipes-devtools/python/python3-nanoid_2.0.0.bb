SUMMARY = "A tiny, secure, URL-friendly, unique string ID generator for Python"
HOMEPAGE = "https://github.com/puyuan/py-nanoid"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"

SRC_URI[sha256sum] = "5a80cad5e9c6e9ae3a41fa2fb34ae189f7cb420b2a5d8f82bd9d23466e4efa68"

S = "${WORKDIR}/nanoid-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-core python3-math"
