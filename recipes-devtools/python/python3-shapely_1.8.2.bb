SUMMARY = "Geometric objects, predicates, and operations"
HOMEPAGE = "https://github.com/shapely/shapely"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=17e3ee10f678b8903ff95af5cda9023a"

SRC_URI[sha256sum] = "572af9d5006fd5e3213e37ee548912b0341fb26724d6dc8a4e3950c10197ebb6"

PYPI_PACKAGE = "Shapely"
S = "${WORKDIR}/${PYPI_PACKAGE}-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-core python3-ctypes python3-doctest python3-json python3-logging python3-math python3-matplotlib python3-numpy python3-pickle python3-pyparsing python3-pytest python3-shell python3-stringoldpython3-xml"