DESCRIPTION = "Kernel module v4l2loopback"
HOMEPAGE = "https://github.com/umlaeute/v4l2loopback"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit module gitpkgv

DEPENDS += "virtual/kernel"

include v4l2loopback.inc

SRC_URI += "file://0001-mark-new-devices-as-ready-for-capture.patch \
            file://99-v4l2loopback.rules \
"

EXTRA_OEMAKE = " \
	KERNEL_DIR=${STAGING_KERNEL_DIR} \
"

MAKE_TARGETS = "v4l2loopback.ko"
MODULES_INSTALL_TARGET = "install"

KERNEL_MODULE_AUTOLOAD += "${PN}"
KERNEL_MODULE_PROBECONF += "${PN}"
module_conf_${PN} = "options v4l2loopback devices=0"

do_install:append () {
	install -d ${D}${sysconfdir}/udev/rules.d
	install -m 0644 ${WORKDIR}/*.rules ${D}${sysconfdir}/udev/rules.d/
}

FILES:${PN} += "${sysconfdir}/udev/rules.d/"
RRECOMMENDS:${PN} += "v4l2loopback-utils"
