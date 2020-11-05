/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * def
 */

package com.microsoft.azure.management.frontdoor.v2020_05_01.implementation;

import com.microsoft.azure.arm.resources.collection.implementation.GroupableResourcesCoreImpl;
import com.microsoft.azure.management.frontdoor.v2020_05_01.FrontDoors;
import com.microsoft.azure.management.frontdoor.v2020_05_01.FrontDoor;
import rx.Observable;
import rx.Completable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import com.microsoft.azure.arm.resources.ResourceUtilsCore;
import com.microsoft.azure.arm.utils.RXMapper;
import rx.functions.Func1;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.frontdoor.v2020_05_01.ValidateCustomDomainOutput;

class FrontDoorsImpl extends GroupableResourcesCoreImpl<FrontDoor, FrontDoorImpl, FrontDoorInner, FrontDoorsInner, NetworkManager>  implements FrontDoors {
    protected FrontDoorsImpl(NetworkManager manager) {
        super(manager.inner().frontDoors(), manager);
    }

    @Override
    protected Observable<FrontDoorInner> getInnerAsync(String resourceGroupName, String name) {
        FrontDoorsInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, name);
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        FrontDoorsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, name).toCompletable();
    }

    @Override
    public Observable<String> deleteByIdsAsync(Collection<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Observable.empty();
        }
        Collection<Observable<String>> observables = new ArrayList<>();
        for (String id : ids) {
            final String resourceGroupName = ResourceUtilsCore.groupFromResourceId(id);
            final String name = ResourceUtilsCore.nameFromResourceId(id);
            Observable<String> o = RXMapper.map(this.inner().deleteAsync(resourceGroupName, name), id);
            observables.add(o);
        }
        return Observable.mergeDelayError(observables);
    }

    @Override
    public Observable<String> deleteByIdsAsync(String...ids) {
        return this.deleteByIdsAsync(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public void deleteByIds(Collection<String> ids) {
        if (ids != null && !ids.isEmpty()) {
            this.deleteByIdsAsync(ids).toBlocking().last();
        }
    }

    @Override
    public void deleteByIds(String...ids) {
        this.deleteByIds(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public PagedList<FrontDoor> listByResourceGroup(String resourceGroupName) {
        FrontDoorsInner client = this.inner();
        return this.wrapList(client.listByResourceGroup(resourceGroupName));
    }

    @Override
    public Observable<FrontDoor> listByResourceGroupAsync(String resourceGroupName) {
        FrontDoorsInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMapIterable(new Func1<Page<FrontDoorInner>, Iterable<FrontDoorInner>>() {
            @Override
            public Iterable<FrontDoorInner> call(Page<FrontDoorInner> page) {
                return page.items();
            }
        })
        .map(new Func1<FrontDoorInner, FrontDoor>() {
            @Override
            public FrontDoor call(FrontDoorInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PagedList<FrontDoor> list() {
        FrontDoorsInner client = this.inner();
        return this.wrapList(client.list());
    }

    @Override
    public Observable<FrontDoor> listAsync() {
        FrontDoorsInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<FrontDoorInner>, Iterable<FrontDoorInner>>() {
            @Override
            public Iterable<FrontDoorInner> call(Page<FrontDoorInner> page) {
                return page.items();
            }
        })
        .map(new Func1<FrontDoorInner, FrontDoor>() {
            @Override
            public FrontDoor call(FrontDoorInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public FrontDoorImpl define(String name) {
        return wrapModel(name);
    }

    @Override
    public Observable<ValidateCustomDomainOutput> validateCustomDomainAsync(String resourceGroupName, String frontDoorName, String hostName) {
        FrontDoorsInner client = this.inner();
        return client.validateCustomDomainAsync(resourceGroupName, frontDoorName, hostName)
        .map(new Func1<ValidateCustomDomainOutputInner, ValidateCustomDomainOutput>() {
            @Override
            public ValidateCustomDomainOutput call(ValidateCustomDomainOutputInner inner) {
                return new ValidateCustomDomainOutputImpl(inner, manager());
            }
        });
    }

    @Override
    protected FrontDoorImpl wrapModel(FrontDoorInner inner) {
        return  new FrontDoorImpl(inner.name(), inner, manager());
    }

    @Override
    protected FrontDoorImpl wrapModel(String name) {
        return new FrontDoorImpl(name, new FrontDoorInner(), this.manager());
    }

}