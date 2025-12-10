package dev.sixik.noesisgui.nsgui;

/**
 * This enum is used by the ItemContainerGenerator to indicate its status.
 */
public enum NSGui_GeneratorStatus {

    /**
     * The generator has not tried to generate content
     */
    GeneratorStatus_NotStarted,

    /**
     * The generator is generating containers
     */
    GeneratorStatus_GeneratingContainers,

    /**
     * The generator has finished generating containers
     */
    GeneratorStatus_ContainersGenerated,

    /**
     * The generator has finished generating containers, but encountered one or more errors
     */
    GeneratorStatus_Error
}
