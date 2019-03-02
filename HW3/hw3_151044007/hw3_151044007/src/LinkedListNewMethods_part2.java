public interface LinkedListNewMethods_part2<E> {
    /**
     * Shows disabled items.
     * @return boolean : false: there is no disabled item. true: there is disabled item/items.
     */
    public boolean showDisabled();

    /**
     * Checks given parametr whether is disabled. If disabled shows message.
     * if parametr can disable, disable it eturn true else return false.
     * @param disabled : to disable.(checks disabled is legal,same object and not disabled method.)
     * @return boolean : if given parametr is convenient and can disable return true else false
     */
    public boolean disabled(E disabled);

    /**
     * Checks given parametr whether is enabled. If enabled shows message
     * if parametr is disable and can enable, enable it return true else return false.
     * @param enabled : to enable.(checks enabled is legal,same object and not enabled method.)
     * @return boolean : if given parametr is convenient and can enable return true else false
     */
    public boolean enabled(E enabled);

    /**
     * if items enable return 1
     * if items disable return 2
     * if there is no matching item return 3
     * @param eORd control item
     * @return 1 ,2 or 3
     */
    public int EnabledOrDisabled(E eORd);

    /**
     * if enable shows enable items
     * if disable shows disable items
     * @param c Enable or disable
     */
    public void printItems(String c);
}
