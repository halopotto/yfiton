/*
 * Copyright 2015 Laurent Pellegrino
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.yfiton.api.parameter.converters;

import com.yfiton.api.exceptions.ConversionException;

/**
 * @author lpellegr
 */
public final class DoubleConverter implements Converter<Double> {

    private static final class LazyHolder {

        private static final DoubleConverter INSTANCE = new DoubleConverter();

    }

    @Override
    public Double convert(String parameterName, String parameterValue) throws ConversionException {
        try {
            return Double.parseDouble(parameterValue);
        } catch (NumberFormatException e) {
            throw new ConversionException(parameterName, parameterValue, Double.class);
        }
    }

    public static DoubleConverter getInstance() {
        return LazyHolder.INSTANCE;
    }

}
