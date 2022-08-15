SUMMARY = "OpenMMLab Computer Vision Foundation"
HOMEPAGE = "https://github.com/open-mmlab/mmcv"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=85c43c131bdb6293487752f4bb95a2f6"

SRC_URI[sha256sum] = "a83bf992fb8b86a5c5a06b49b40cb2cd56b2ac583f41e2e835a3df3825b44657"

S = "${WORKDIR}/mmcv-${PV}"

inherit setuptools3 pypi

#PACKAGECONFIG ?= "all build optional tests"
PACKAGECONFIG[all] = ",,,python3-pillow python3-pyturbojpeg python3-addict python3-coverage python3-lmdb python3-ninja python3-numpy python3-packaging python3-protobuf~ python3-pytest python3-pytest-runner python3-pyyaml python3-scipy python3-tifffile python3-yapf"
PACKAGECONFIG[build] = ",,,python3-pytest-runner"
PACKAGECONFIG[optional] = ",,,python3-ninja"
PACKAGECONFIG[tests] = ",,,python3-pyturbojpeg python3-coverage python3-lmdb python3-protobuf~ python3-pytest python3-scipy python3-tifffile"

RDEPENDS:${PN} += "python3-pillow python3-addict python3-numpy python3-opencv python3-packaging python3-pyyaml python3-yapf"
