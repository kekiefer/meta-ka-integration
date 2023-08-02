SUMMARY = "ANTLR runtime for Python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://PKG-INFO;md5=86db285bb0a3d95f91912f736520a6bf"

SRC_URI[sha256sum] = "f224469b4168294902bb1efa80a8bf7855f24c99aef99cbefc1bcd3cce77881b"

PYPI_PACKAGE = "antlr4-python3-runtime"

inherit pypi python_setuptools_build_meta

BBCLASSEXTEND = "nativesdk native"
