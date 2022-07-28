SUMMARY = "Render rich text, tables, progress bars, syntax highlighting, markdown and more to the terminal"
HOMEPAGE = "https://github.com/willmcgugan/rich"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b5f0b94fbc94f5ad9ae4efcf8a778303"

SRC_URI[sha256sum] = "63a5c5ce3673d3d5fbbf23cd87e11ab84b6b451436f1b7f19ec54b6bc36ed7ca"

S = "${WORKDIR}/rich-${PV}"

inherit setuptools3 pypi

RDEPENDS:${PN} += "python3-attrs python3-core python3-ctypes python3-dataclasses python3-datetime python3-html python3-image python3-ipython python3-math python3-mmap python3-numbers python3-pygments python3-terminal python3-typing-extensions python3-unixadmin"
