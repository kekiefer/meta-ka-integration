SUMMARY = "Library for rendering DVC plots"
HOMEPAGE = "https://github.com/iterative/dvc-render"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a0759cfa711bc858ab82afbbc3ae0ae"

SRC_URI[sha256sum] = "6309e963f730b0a58c6e190ace02e076932fca66fcc55ea5e19086495a443e83"

S = "${WORKDIR}/dvc-render-${PV}"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "python3-matplotlib python3-tabulate"
