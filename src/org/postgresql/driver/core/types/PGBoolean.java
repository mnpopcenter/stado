/*****************************************************************************
 * Copyright (C) 2008 EnterpriseDB Corporation.
 * Copyright (C) 2011 Stado Global Development Group.
 * Copyright (c) 2016 Regents of the University of Minnesota
 *
 * This file is part of the Minnesota Population Center's Terra Populus project.
 * For copyright and licensing information, see the NOTICE and LICENSE files
 * in this project's top-level directory, and also online at:
 * https://github.com/mnpopcenter/stado
 *
 * This file is part of Stado.
 *
 * Stado is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Stado is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Stado.  If not, see <http://www.gnu.org/licenses/>.
 *
 * You can find Stado at http://www.stado.us
 *
 ****************************************************************************/
package org.postgresql.driver.core.types;

import java.sql.Types;

import org.postgresql.driver.util.GT;
import org.postgresql.driver.util.PSQLException;
import org.postgresql.driver.util.PSQLState;

/**
 * @author davec
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class PGBoolean implements PGType 
{
    private Boolean val;
    
    public PGBoolean(Boolean x)
    {
        val = x;
    }
    public static PGType castToServerType( Boolean val, int targetType ) throws PSQLException
    {
        try
        {
        switch ( targetType )
        {
            case Types.BIGINT:
                return new PGLong(new Long( val.booleanValue()==true?1:0 ));
            case Types.INTEGER:
                return new PGInteger( new Integer(  val.booleanValue()==true?1:0  ) );
            case Types.SMALLINT:
            case Types.TINYINT:
                return new PGShort( new Short( val.booleanValue()==true?(short)1:(short)0  ) );
            case Types.VARCHAR:
            case Types.LONGVARCHAR:                
                return new PGString( val.booleanValue()==true?"true":"false" );
            case Types.DOUBLE:
            case Types.FLOAT:
            		return new PGDouble( new Double(val.booleanValue()==true?1:0));
            case Types.REAL:
        		return new PGFloat( new Float(val.booleanValue()==true?1:0));
            case Types.NUMERIC:
            case Types.DECIMAL:
                return new PGBigDecimal( new java.math.BigDecimal(val.booleanValue()==true?1:0));
            
            case Types.BIT:
                return new PGBoolean( val );
            default:
                return new PGUnknown( val );
        }
        }
        catch(Exception ex)
        {
            throw new PSQLException(GT.tr("Cannot convert an instance of {0} to type {1}", new Object[]{val.getClass().getName(),"Types.OTHER"}), PSQLState.INVALID_PARAMETER_TYPE, ex);
        }
    }
    public String toString()
    {
        return val.booleanValue()==true?"true":"false";
    }
    
}
