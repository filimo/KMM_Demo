//
//  Publisher.swift
//  iosApp
//
//  Created by Falcon on 16.02.22.
//  Copyright © 2022 orgName. All rights reserved.
//
import Combine
import KMPNativeCoroutinesCombine
import shared

enum ParserError: Error {
    case invalidCasting(String)
}

extension Publisher {
    func bind<T: Equatable>(
        flowItem: Observable<AnyObject>,
        defaultValue: T,
        canNil: Bool = true,
        in set: inout Set<AnyCancellable>
    ) -> AnyPublisher<T, Never> where Self.Output: Equatable, Self.Failure == Never {
        dropFirst()
            .removeDuplicates()
            .print("Send value to Flow: ")
            .sink { flowItem.setValue(value: $0) }
            .store(in: &set)

        return createPublisher(for: flowItem.flowNative)
            .errorToLog()
            .map {
                let val = $0 as? T

                guard let val = val else {
                    if canNil == false {
                        Swift.print("Parsing error: \(String(describing: $0)) as? \(T.self) = \(String(describing: val))")
                    }

                    return defaultValue
                }

                return val
            }
            .print("Get value from Flow: ")
            .removeDuplicates()
            .receive(on: DispatchQueue.main)
            .eraseToAnyPublisher()
    }
}

extension Publisher {
    func errorToLog() -> AnyPublisher<Output, Never> {
        self
            .mapError { $0 as! ParserError }
            .catch { error -> Empty<Output, Never> in
                if case .invalidCasting(let error) = error {
                    Swift.print("Parser error: \(error)")
                } else {
                    Swift.print(error.localizedDescription)
                }

                return Empty<Output, Never>()
            }
            .eraseToAnyPublisher()
    }
}
