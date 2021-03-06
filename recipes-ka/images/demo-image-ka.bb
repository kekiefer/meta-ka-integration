SUMMARY = "KA demo image with Weston compositor"
LICENSE = "MIT"

inherit core-image
inherit nopackages
inherit features_check

REQUIRED_DISTRO_FEATURES = "wayland opengl systemd"

PACKAGE_CLASSES ?= "package_rpm"

IMAGE_FEATURES += "ssh-server-openssh hwcodecs weston"
EXTRA_IMAGE_FEATURES += "package-management debug-tweaks empty-root-password allow-empty-password ssh-server-openssh"

CORE_IMAGE_BASE_INSTALL += " \
    connman \
    connman-client \
    cuda-libraries \
    packagegroup-demo-base \
    packagegroup-demo-basetests \
    packagegroup-demo-egltests \
    packagegroup-demo-systemd \
    packagegroup-demo-westontests \
    packagegroup-ka-deps \
"

TOOLCHAIN_HOST_TASK += "nativesdk-packagegroup-cuda-sdk-host"

CORE_IMAGE_BASE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', 'weston-xwayland matchbox-terminal packagegroup-demo-x11tests', '', d)}"
CORE_IMAGE_BASE_INSTALL += "${@bb.utils.contains('DISTRO_FEATURES', 'vulkan', 'packagegroup-demo-vulkantests', '', d)}"

SYSTEMD_DEFAULT_TARGET = "graphical.target"

CORE_IMAGE_EXTRA_INSTALL += " \
    v4l-utils \
    v4l2loopback \
    l4t-usb-device-mode \
    tensorrt-tests \
"
