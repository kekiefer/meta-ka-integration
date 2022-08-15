SUMMARY = "PyWavelets, wavelet transform module"
HOMEPAGE = "https://github.com/PyWavelets/pywt"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8acfa576998385b0a0df529d6db9ac38"

SRC_URI[sha256sum] = "cbaa9d62052d9daf8da765fc8e7c30c38ea2b8e9e1c18841913dfb4aec671ee5"

PYPI_PACKAGE = "PyWavelets"
S = "${WORKDIR}/${PYPI_PACKAGE}-${PV}"

inherit setuptools3 pypi

DEPENDS += "python3-numpy-native"

RDEPENDS:${PN} += "python3-numpy"
