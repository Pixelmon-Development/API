package com.envyful.api.platform;

import com.envyful.api.player.Identifiable;
import com.envyful.api.text.Placeholder;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Collection;

/**
 *
 * An interface to represent a command executor in a Minecraft setting
 *
 */
public interface Messageable<T> extends Identifiable {

    /**
     *
     * Gets the platform relative representation of the player
     *
     * @return The parent
     */
    @Nullable
    T getParent();

    /**
     *
     * Sends messages to the player
     *
     * @param messages The messages to send
     * @param placeholders The placeholders to replace in the messages
     */
    default void message(Collection<String> messages, Placeholder... placeholders) {
        PlatformProxy.sendMessage(this, messages, placeholders);
    }

    /**
     *
     * Sends messages to the player
     *
     * @param messages The messages to send
     */
    void message(Object... messages);

    /**
     *
     * Checks if the player has the permission
     *
     * @param permission The permission to check
     * @return If the player has the permission
     */
    default boolean hasPermission(String permission) {
        return PlatformProxy.hasPermission(this.getParent(), permission);
    }
}
