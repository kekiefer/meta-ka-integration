SUMMARY = "Flexible Python configuration system. The last one you will ever need."
HOMEPAGE = "https://github.com/omry/omegaconf"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7404c7fb5d66cfa18ddcd7b007a3e157"

SRC_URI[sha256sum] = "d5d4b6d29955cc50ad50c46dc269bcd92c6e00f5f90d23ab5fee7bfca4ba4cc7"

S = "${WORKDIR}/omegaconf-${PV}"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "python3-core python3-typing-extensions python3-antlr4-runtime"
