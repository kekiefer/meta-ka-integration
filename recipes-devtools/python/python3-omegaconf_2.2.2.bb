SUMMARY = "A flexible configuration library"
HOMEPAGE = "https://github.com/omry/omegaconf"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7404c7fb5d66cfa18ddcd7b007a3e157"

SRC_URI[sha256sum] = "65c85b2a84669a570c70f2df00de3cebcd9b47a8587d3c53b1aa5766bb096f77"

S = "${WORKDIR}/omegaconf-${PV}"

inherit setuptools3 pypi

DEPENDS += "virtual/java-native"

RDEPENDS:${PN} += "python3-core python3-attrs python3-pyyaml python3-antlr4-runtime"
