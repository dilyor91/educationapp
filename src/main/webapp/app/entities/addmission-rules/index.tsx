import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import AddmissionRules from './addmission-rules';
import AddmissionRulesDetail from './addmission-rules-detail';
import AddmissionRulesUpdate from './addmission-rules-update';
import AddmissionRulesDeleteDialog from './addmission-rules-delete-dialog';

const AddmissionRulesRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<AddmissionRules />} />
    <Route path="new" element={<AddmissionRulesUpdate />} />
    <Route path=":id">
      <Route index element={<AddmissionRulesDetail />} />
      <Route path="edit" element={<AddmissionRulesUpdate />} />
      <Route path="delete" element={<AddmissionRulesDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default AddmissionRulesRoutes;
