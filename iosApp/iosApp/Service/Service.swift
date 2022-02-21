//
//  Service.swift
//  iosApp
//
//  Created by Falcon on 18.02.22.
//  Copyright © 2022 orgName. All rights reserved.
//
import Combine
import shared

class Service: ObservableObject {
    static let shared = Service()

    @Published var visibility: Bool? = nil
    @Published var valueNull: String = ""
    @Published var value: String = ""

    let controls = Repository().getNativeControlList()

    var subs = Set<AnyCancellable>()

    init() {
        $visibility
            .bind(flowItem: controls[0].visibility, defaultValue: true, in: &subs)
            .assign(to: &$visibility)

        $valueNull
            .bind(flowItem: controls[0].value, defaultValue: "nil", in: &subs)
            .assign(to: &$valueNull)

        if let item2 = controls[0].children?[0] {
            $value
                .bind(flowItem: item2.value, defaultValue: "", in: &subs)
                .assign(to: &$value)
        }
    }
}
