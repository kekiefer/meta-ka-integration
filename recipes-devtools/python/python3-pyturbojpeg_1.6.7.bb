SUMMARY = "A Python wrapper of libjpeg-turbo for decoding and encoding JPEG image."
HOMEPAGE = "https://github.com/lilohuang/PyTurboJPEG"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f639fb15e676864fba59a71b596a9175"

SRC_URI[sha256sum] = "7bef8397b9211d62d7a3e1bd19df11422178e7c3ad627f97ec953a1c5e96cd80"

PYPI_PACKAGE = "PyTurboJPEG"
S = "${WORKDIR}/${PYPI_PACKAGE}-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-numpy libjpeg-turbo"
