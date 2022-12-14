package dev.sweplays.multicurrency.data;

import dev.sweplays.multicurrency.MultiCurrency;
import dev.sweplays.multicurrency.account.Account;
import dev.sweplays.multicurrency.currency.Currency;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class DataStore {

    public final MultiCurrency plugin = MultiCurrency.getInstance();

    @Getter
    private final String name;

    public DataStore(String name) {
        this.name = name;
    }

    @Getter
    private static final List<DataStore> methods = new ArrayList<>();

    public static DataStore getMethod(String name) {
        for (DataStore store : getMethods()) {
            if (store.getName().equalsIgnoreCase(name)) {
                return store;
            }
        }
        return null;
    }

    public abstract void initialize();

    public abstract void saveAccount(Account account);

    public abstract void deleteAccount(Account account);

    public abstract void deleteBalance(Account account, Currency currency);

    public abstract void createAccount(Account account);

    public abstract void loadCurrencies();

    public abstract void deleteCurrency(Currency currency);

    public abstract List<Account> getOfflineAccounts();

    public abstract void saveCurrency(Currency currency);

    public abstract Account loadAccount(UUID uuid);
}
