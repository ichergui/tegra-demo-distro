DESCRIPTION = "Packagegroup for inclusion in all Tegra demo images"

LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = " \
    haveged \
    procps \
    sshfs-fuse \
    strace \
    tegra-tools-tegrastats \
    gptfdisk \
    i2c-tools \
    tegra-bup-payload \
    tegra-eeprom-tool \
    tegra-fuse-tool \
    tegra-sysinstall-tools \
"

RDEPENDS:${PN}:append:cryptparts = " \
    systemd-conf-crypttab \
"

RRECOMMENDS:${PN}:append = " \
    kernel-module-hid-logitech-hidpp \
    kernel-module-hid-logitech-dj \
    kernel-module-uvcvideo \
"
