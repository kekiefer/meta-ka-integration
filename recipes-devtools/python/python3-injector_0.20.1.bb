SUMMARY = "Injector - Python dependency injection framework, inspired by Guice"
HOMEPAGE = "https://github.com/alecthomas/injector"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=0ecff75971cd0121546c6e10e3fc6710"

SRC_URI[sha256sum] = "8661b49a2f8309ce61e3a6a82b7acb5e225c4bde8e17d1610c893a670dff223a"

S = "${WORKDIR}/injector-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-core python3-logging python3-typing-extensions python3-mypy"
