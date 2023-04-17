DESCRIPTION = "Installer tegraflash package"
LICENSE = "MIT"

COMPATIBLE_MACHINE = "(tegra)"

PACKAGE_INSTALL = "sysinstall-pkg"

IMAGE_FEATURES = "empty-root-password allow-empty-password"
IMAGE_LINUGAS = ""

inherit core-image

IMAGE_FSTYPES:forcevariable = "tegraflash"

IMAGE_TEGRAFLASH_KERNEL:tegra234 = "${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}"
TEGRAFLASH_PKG_DEPENDS:append:tegra234 = " linux-tegra:do_deploy"

KERNEL_ARGS:remove = "console=tty0"
KERNEL_ARGS:remove = "systemd.volatile=overlay"

ROOTFS_POSTPROCESS_COMMAND:prepend = "ensure_data_exists; ensure_media_m2_exists; trim_fstab;"
ROOTFS_POSTPROCESS_COMMAND:remove = "mender_update_fstab_file;"
ROOTFS_POSTPROCESS_COMMAND:remove = "mender_create_scripts_version_file;"

ROOTFS_EXTRADEPS = ""
do_rootfs[depends] += "${ROOTFS_EXTRADEPS}"

trim_fstab() {
    if [ -e ${IMAGE_ROOTFS}${sysconfdir}/fstab ]; then
        sed -i -n -e'1,/^tmpfs/p' ${IMAGE_ROOTFS}${sysconfdir}/fstab
    fi
}

ensure_data_exists() {
    [ -d "${IMAGE_ROOTFS}/data" ] || install -d "${IMAGE_ROOTFS}/data"
}

ensure_media_m2_exists() {
    [ -d "${IMAGE_ROOTFS}/media/m2" ] || install -d "${IMAGE_ROOTFS}/media/m2"
}
