SUMMARY = "A lightweight, optionally typed expression language with a custom grammar for matching arbitrary Python objects."
HOMEPAGE = "https://github.com/zeroSteiner/rule-engine"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2d7daf67b4811fd7c157da45b92e0c71"

SRC_URI[sha256sum] = "7f26767f56a45ed0041f6990bf16e87fc98769654fc3cf44dfcbb14496794878"

S = "${WORKDIR}/rule-engine-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-ply python3-dateutil"
