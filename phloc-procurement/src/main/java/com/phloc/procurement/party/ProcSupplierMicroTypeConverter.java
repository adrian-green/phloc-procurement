/**
 * Copyright (C) 2006-2014 phloc systems
 * http://www.phloc.com
 * office[at]phloc[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.phloc.procurement.party;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.phloc.commons.CGlobal;
import com.phloc.commons.annotations.Nonempty;
import com.phloc.commons.microdom.IMicroElement;
import com.phloc.commons.microdom.impl.MicroElement;
import com.phloc.commons.string.StringParser;

public final class ProcSupplierMicroTypeConverter extends AbstractProcPartyMicroTypeConverter
{
  private static final String ATTR_CLIENT = "client";

  @Nonnull
  public IMicroElement convertToMicroElement (@Nonnull final Object aObject,
                                              @Nullable final String sNamespaceURI,
                                              @Nonnull @Nonempty final String sTagName)
  {
    final ProcSupplier aValue = (ProcSupplier) aObject;
    final IMicroElement aElement = new MicroElement (sNamespaceURI, sTagName);
    convertToMicroElementPartial (aValue, aElement);
    aElement.setAttribute (ATTR_CLIENT, aValue.getClient ());
    return aElement;
  }

  @Nonnull
  public ProcSupplier convertToNative (@Nonnull final IMicroElement aElement)
  {
    final ProcSupplier ret = new ProcSupplier ();
    convertToNativePartial (ret, aElement);
    ret.setClient (StringParser.parseInt (aElement.getAttribute (ATTR_CLIENT), CGlobal.ILLEGAL_UINT));
    return ret;
  }
}
