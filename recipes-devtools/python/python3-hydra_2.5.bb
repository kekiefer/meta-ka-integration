SUMMARY = "A high performance persistent bloom filter"
HOMEPAGE = "http://github.com/crankycoder/Hydra"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://license.txt;md5=6235397d4f67b8f5cb03c385760044ec"

SRC_URI[sha256sum] = "247091b9c279c77686ea995f0f07070a28870c1942959b1474ad57076074384a"

PYPI_PACKAGE = "Hydra"
S = "${WORKDIR}/${PYPI_PACKAGE}-${PV}"

inherit setuptools3 pypi

DEPENDS += "python3-cython-native python3-native"

RDEPENDS:${PN} += "python3-core"

do_compile:prepend() {
    rm -f ${S}/src/_hydra.c
    cythonize3 src/_hydra.pyx
}
