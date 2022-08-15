SUMMARY = "MIM Installs OpenMMLab packages"
HOMEPAGE = "https://github.com/open-mmlab/mim"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI[sha256sum] = "501c94ee936b0f0a177b707cae3570a96f58eadcf15ae39d6f9d08cc55b4854e"

S = "${WORKDIR}/openmim-${PV}"

inherit setuptools3 pypi

#PACKAGECONFIG ?= "tests"
PACKAGECONFIG[tests] = ",,,python3-coverage python3-flake8 python3-interrogate python3-pytest"

RDEPENDS:${PN} += "python3-click python3-colorama python3-model-index python3-pandas python3-pip python3-requests python3-rich python3-tabulate"
