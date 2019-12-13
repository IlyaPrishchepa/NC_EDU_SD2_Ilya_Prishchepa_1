import {Category} from "../category/category";

export class Service {
  id?:number;
  name?: string;
  price?: string;
  description?: string;
  selectedEwallet?:number;
  categoryId?: Category;
  companyId?: number;
}
