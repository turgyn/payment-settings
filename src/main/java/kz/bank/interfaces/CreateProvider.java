package kz.bank.interfaces;


import kz.bank.entity.*;

/**
 * Платежная система*
 *
 * @author u11549
 * @Date 30.05.2022
 */
public interface CreateProvider {


    /**  Статус платежа **/
    public Long addStatus(ProviderStatus providerStatus);


    /**  На каких каналах доступен платеж **/
    public Long addChannel(ProviderChannel providerChannel);

    /**  Настройки лимитов **/
    public Long addLimit(ProviderLimit providerLimit);

    /**  Признак на создание избранного,шаблона,автоплатежи  и подключения к активной корзине платежей и т.д.  **/
    public Long addSkill(ProviderSkill providerSkill);

    /**  На каких регионах доступен платеж **/
    public void addRegionBuffer();

    /**  Настройки категорий ПУ **/
    public void addCategoryBuffer();






}
