SUMMARY = "Extended pickling support for Python objects"
HOMEPAGE = "https://github.com/cloudpipe/cloudpickle"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b4d59aa5e2cc777722aac17841237931"

SRC_URI = "https://files.pythonhosted.org/packages/a7/c8/ae6f77da9d02e63f0614c28f82e575b42eb5c4e9fb1bcdaa24ca03eaa00a/cloudpickle-${PV}.tar.gz"
SRC_URI[md5sum] = "acad60b498a512767227f8dd9e8792a1"
SRC_URI[sha256sum] = "bb233e876a58491d9590a676f93c7a5473a08f747d5ab9df7f9ce564b3e7938e"

S = "${WORKDIR}/cloudpickle-${PV}"

inherit setuptools3

RDEPENDS:${PN} += "python3-asyncio python3-core python3-distutils python3-io python3-logging python3-math python3-multiprocessing python3-netclient python3-numpy python3-pickle python3-py python3-pytest python3-typing-extensions python3-unittest python3-xml"
