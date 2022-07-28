SUMMARY = "Extended pickling support for Python objects"
HOMEPAGE = "https://github.com/cloudpipe/cloudpickle"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b4d59aa5e2cc777722aac17841237931"

SRC_URI[sha256sum] = "bb233e876a58491d9590a676f93c7a5473a08f747d5ab9df7f9ce564b3e7938e"

S = "${WORKDIR}/cloudpickle-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-core"
