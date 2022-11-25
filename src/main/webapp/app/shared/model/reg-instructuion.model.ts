export interface IRegInstructuion {
  id?: number;
  titleUz?: string;
  titleRu?: string;
  titleKr?: string;
  contentUz?: string;
  contentRu?: string;
  contentKr?: string;
  status?: boolean;
}

export const defaultValue: Readonly<IRegInstructuion> = {
  status: false,
};
