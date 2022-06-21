DESCRIPTION = "Kernel module v4l2loopback"
HOMEPAGE = "https://github.com/umlaeute/v4l2loopback"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit gitpkgv

include v4l2loopback.inc

FILES:${PN} = "${bindir}/v4l2loopback-ctl"

EXTRA_OEMAKE = " \
	PREFIX=${D}/usr \
"

do_compile() {
    oe_runmake utils
}

do_install() {
    oe_runmake install-utils
}

RDEPENDS:${PN} = "bash"

