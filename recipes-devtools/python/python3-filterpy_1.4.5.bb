SUMMARY = "Kalman filtering and optimal estimation library"
HOMEPAGE = "https://github.com/rlabbe/filterpy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=486fe7f6e03034ab853c9383028b4531"

SRC_URI[sha256sum] = "4f2a4d39e4ea601b9ab42b2db08b5918a9538c168cff1c6895ae26646f3d73b1"

PYPI_PACKAGE_EXT = "zip"
S = "${WORKDIR}/filterpy-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-core python3-math python3-matplotlib python3-numpy python3-scipy"
