SUMMARY = "Ahead of Time compiler for numeric kernels"
HOMEPAGE = "https://github.com/serge-sans-paille/pythran"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e277a0b6033e0cb3d510c86b74144b01"

SRC_URI += "file://0001-Disable-default-library-stripping.patch"
#SRC_URI = "https://files.pythonhosted.org/packages/88/9f/161f08131abf7f23920cee29b691de27f10fd97ac09fb2f3532b3a7f9b96/pythran-${PV}.tar.gz"
SRC_URI[md5sum] = "e09e90484771937ab499380858bdb18d"
SRC_URI[sha256sum] = "0b2cba712e09f7630879dff69f268460bfe34a6d6000451b47d598558a92a875"

S = "${WORKDIR}/pythran-${PV}"

inherit setuptools3 pypi

# The following configs & dependencies are from setuptools extras_require.
# These dependencies are optional, hence can be controlled via PACKAGECONFIG.
# The upstream names may not correspond exactly to bitbake package names.
#
# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "doc"
PACKAGECONFIG[doc] = ",,,python3-guzzle_sphinx_theme python3-nbsphinx python3-numpy python3-scipy"

# WARNING: the following rdepends are from setuptools install_requires. These
# upstream names may not correspond exactly to bitbake package names.
RDEPENDS:${PN} += "python3-beniget python3-gast python3-numpy python3-ply"

# WARNING: the following rdepends are determined through basic analysis of the
# python sources, and might not be 100% accurate.
RDEPENDS:${PN} += "python3-core python3-crypt python3-ctypes python3-datetime python3-distutils python3-io python3-logging python3-numbers python3-numpy python3-ply python3-shell"

# WARNING: We were unable to map the following python package/module
# dependencies to the bitbake packages which include them:
#    ConfigParser
#    IPython.core
#    IPython.core.magic
#    beniget
#    colorlog
#    gast
#    pythran_openblas

BBCLASSEXTEND = "native nativesdk"
