SUMMARY = "OpenMMLab Image Classification Toolbox and Benchmark"
HOMEPAGE = "https://github.com/open-mmlab/mmclassification"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI[sha256sum] = "efae89826d0f217b103a0cbf5bec8b0527a50fd581201742b7906c5235a98ddd"

S = "${WORKDIR}/mmcls-${PV}"

inherit setuptools3 pypi

PACKAGECONFIG ?= "mim"
PACKAGECONFIG[mim] = ",,,python3-mmcv"
PACKAGECONFIG[optional] = ",,,python3-albumentations python3-colorama python3-requests python3-rich"
PACKAGECONFIG[tests] = ",,,python3-codecov python3-flake8 python3-interrogate python3-isort python3-mmdet python3-pytest python3-xdoctest python3-yapf"

RDEPENDS:${PN} += "python3-matplotlib python3-numpy python3-packaging"
