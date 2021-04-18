package dev.triumphteam.gui;

import dev.triumphteam.gui.builder.GuiOptions;
import dev.triumphteam.gui.components.GuiType;
import dev.triumphteam.gui.components.ScrollType;
import dev.triumphteam.gui.guis.BaseGui;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public final class PaperGuiOptions implements GuiOptions {

    private final Component title;
    private final int rows;
    private final int pageSize;
    private final GuiType guiType;
    private final ScrollType scrollType;

    public PaperGuiOptions(
            @NotNull final Component title,
            final int rows,
            final int pageSize,
            @NotNull final GuiType guiType,
            @NotNull final ScrollType scrollType
    ) {
        int finalRows = rows;
        if (!(rows >= 1 && rows <= 6)) finalRows = 1;

        this.rows = finalRows;
        this.title = title;
        this.pageSize = pageSize;
        this.guiType = guiType;
        this.scrollType = scrollType;
    }

    public PaperGuiOptions(@NotNull final Component title, final int rows, final int pageSize) {
        this(title, rows, pageSize, GuiType.CHEST, ScrollType.HORIZONTAL);
    }

    @NotNull
    @Override
    public GuiType guiType() {
        return guiType;
    }

    @Override
    public int rows() {
        return rows;
    }

    @Override
    public int getPageSize() {
        return pageSize;
    }

    @NotNull
    @Override
    public ScrollType scrollType() {
        return scrollType;
    }

    @NotNull
    @Override
    public Inventory createInventory(final @NotNull BaseGui baseGui) {
        return Bukkit.createInventory(baseGui, rows * 9, title);
    }

}
